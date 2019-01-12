using System;
using System.Collections.Generic;
using System.Linq;
using Microsoft.AspNetCore.Mvc;
using ToDoList.Data;
using ToDoList.Models;

namespace ToDoList.Controllers
{
    public class TaskController : Controller
    {
        public IActionResult Index()
        {
            using (var db = new ToDoDbContext())
            {
                List<Task> tasks = db.Tasks.ToList();

                return View(tasks);
            }
        }

        [HttpGet]
        public IActionResult Create()
        {
            return View();
        }

        [HttpPost]
        public IActionResult Create(string title, string comments)
        {
            if (!ModelState.IsValid)
            {
                return RedirectToAction("Index");
            }

            Task newTask = new Task()
            { Title = title, Comments = comments };

            using (var db = new ToDoDbContext())
            {
                db.Add(newTask);
                db.SaveChanges();
            }

            return RedirectToAction("Index");
        }

        [HttpGet]
        public IActionResult Edit(int id)
        {
            using (var db = new ToDoDbContext())
            {
                var oldTask = db.Tasks.FirstOrDefault(x => x.Id == id);

                if (oldTask == null)
                {
                    return RedirectToAction("Index");
                }

                return View(oldTask);
            }
        }
        [HttpPost]

        public IActionResult Edit(Task newTask)
        {

            if (!ModelState.IsValid)
            {
                return RedirectToAction("Index");
            }

            using (var db = new ToDoDbContext())
            {
                var oldTask = db.Tasks.FirstOrDefault(x => x.Id == newTask.Id);

                if (oldTask == null)
                {
                    return RedirectToAction("Index");
                }

                oldTask.Title = newTask.Title;
                oldTask.Comments = newTask.Comments;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
        }

        [HttpGet]
        public IActionResult Details(int id)
        {

            using (var db = new ToDoDbContext())
            {
                var oldTask = db.Tasks.FirstOrDefault(x => x.Id == id);

                if (oldTask == null)
                {
                    return RedirectToAction("Index");
                }

                return View(oldTask);
            }
        }

        [HttpPost]
        public IActionResult Delete(int id)
        {
            using (var db =  new ToDoDbContext())
            {
                var oldTask = db.Tasks.FirstOrDefault(x => x.Id == id);

                if (oldTask == null)
                {
                    return RedirectToAction("Index");
                }

                db.Tasks.Remove(oldTask);
                db.SaveChanges();
                return RedirectToAction("Index");
            }
        }
    }
}