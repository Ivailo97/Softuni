using System;
using System.Collections.Generic;
using System.Linq;
using Microsoft.AspNetCore.Mvc;
using TeisterMask.Data;
using TeisterMask.Models;

namespace TeisterMask.Controllers
{
    public class TaskController : Controller
    {
        public IActionResult Index()
        {
            using (var db = new TeisterMaskDbContext())
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
        public IActionResult Create(Task task)
        {
            if (!ModelState.IsValid)
            {
                return RedirectToAction("Index");
            }

            using (var db = new TeisterMaskDbContext())
            {
                db.Add(task);
                db.SaveChanges();

                return RedirectToAction("Index");
            }
        }

        [HttpGet]
        public IActionResult Edit(int id)
        {
            using (var db = new TeisterMaskDbContext())
            {
                Task oldTask = db.Tasks.FirstOrDefault(x => x.Id == id);

                if (oldTask == null)
                {
                    return RedirectToAction("Index");
                }

                return View(oldTask);

            }
        }

        [HttpPost]
        public IActionResult Edit(Task task)
        {
            using (var db = new TeisterMaskDbContext())
            {
                Task oldTask = db.Tasks.FirstOrDefault(x => x.Id == task.Id);

                if (oldTask == null)
                {
                    return RedirectToAction("Index");
                }

                oldTask.Status = task.Status;
                oldTask.Title = task.Title;
                db.SaveChanges();

                return RedirectToAction("Index");
            }
        }

        [HttpGet]
        public IActionResult Delete(int id)
        {
            using (var db = new TeisterMaskDbContext())
            {
                Task oldTask = db.Tasks.FirstOrDefault(x => x.Id == id);

                if (oldTask == null)
                {
                    return RedirectToAction("Index");
                }

                return View(oldTask);
            }
        }

        [HttpPost]
        public IActionResult Delete(Task task)
        {
            using (var db = new TeisterMaskDbContext())
            {
                Task oldTask = db.Tasks.FirstOrDefault(x => x.Id == task.Id);

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