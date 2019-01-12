using System;
using System.Collections.Generic;
using System.Linq;

namespace TeamworkProject
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            List<Team> teams = new List<Team>();

            List<string> disbanded = new List<string>();

            for (int i = 0; i < n; i++)
            {
                string[] creatorAndTeam = Console.ReadLine().Split('-');
                string creator = creatorAndTeam[0];
                string teamName = creatorAndTeam[1];

                Team currentTeam = new Team() { CreatorName = creator, Name = teamName, Members = new List<string>() };

                if (teams.FirstOrDefault(x => x.Name == teamName) != null)
                {
                    Console.WriteLine($"Team {teamName} was already created!");
                }

                if (teams.FirstOrDefault(x => x.CreatorName == creator) != null)
                {
                    Console.WriteLine($"{creator} cannot create another team!");
                }

                bool condition = teams.FirstOrDefault(x => x.Name == teamName) == null &&
                    teams.FirstOrDefault(x => x.CreatorName == creator) == null;

                if (condition)
                {
                    Console.WriteLine($"Team {teamName} has been created by {creator}!");
                    teams.Add(currentTeam);
                }
            }

            while (true)
            {
                string line = Console.ReadLine();

                if (line == "end of assignment")
                {
                    break;
                }

                string[] tokens = line.Split("->");

                string nameToJoin = tokens[0];
                string teamToJoin = tokens[1];

                if (teams.FirstOrDefault(x => x.Name == teamToJoin) == null)
                {
                    Console.WriteLine($"Team {teamToJoin} does not exist!");
                }
                else if (teams.FirstOrDefault(x => x.Members.Contains(nameToJoin)) != null
                    || teams.FirstOrDefault(x => x.CreatorName == nameToJoin) != null)
                {
                    Console.WriteLine($"Member {nameToJoin} cannot join team {teamToJoin}!");
                }
                else
                {
                    Team current = teams.FirstOrDefault(x => x.Name == teamToJoin);

                    if (!current.Members.Contains(nameToJoin))
                    {
                        current.Members.Add(nameToJoin);
                    }
                }
            }

            foreach (var team in teams)
            {
                if (team.Members.Count == 0)
                {
                    disbanded.Add(team.Name);
                }
            }

            teams.RemoveAll(x => x.Members.Count == 0);

            foreach (var team in teams.OrderByDescending(x => x.Members.Count).ThenBy(x => x.Name))
            {
                Console.WriteLine(team.Name);
                Console.WriteLine($"- {team.CreatorName}");

                foreach (var member in team.Members.OrderBy(x => x))
                {
                    Console.WriteLine($"-- {member}");
                }
            }

            Console.WriteLine("Teams to disband:");
            foreach (var team in disbanded.OrderBy(x => x))
            {
                Console.WriteLine(team);
            }
        }
    }

    class Team
    {
        public string Name { get; set; }
        public List<string> Members { get; set; }
        public string CreatorName { get; set; }

    }
}
